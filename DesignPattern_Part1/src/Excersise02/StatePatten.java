package Excersise02;

//Interface cho trạng thái thuế
interface TaxState {
	double applyTax(double price);
}

//Trạng thái miễn thuế
class NoTaxState implements TaxState {
	@Override
	public double applyTax(double price) {
		return 0;
	}
}

//Trạng thái thuế thường
class NormalTaxState implements TaxState {
	private static final double NORMAL_RATE = 0.10;

	@Override
	public double applyTax(double price) {
		return price * NORMAL_RATE;
	}
}

//Trạng thái thuế cao (xa xỉ)
class HighTaxState implements TaxState {
	private static final double HIGH_RATE = 0.20;

	@Override
	public double applyTax(double price) {
		return price * HIGH_RATE;
	}
}

//Context sử dụng State
class ProductWithState {
	private String name;
	private double price;
	private TaxState taxState;

	public ProductWithState(String name, double price) {
		this.name = name;
		this.price = price;
		this.taxState = new NoTaxState(); // Trạng thái mặc định
	}

	public void setTaxState(TaxState taxState) {
		this.taxState = taxState;
	}

	public double calculateTotalPrice() {
		return price + taxState.applyTax(price);
	}
}