package Excersise02;


interface TaxStrategy {
	double calculateTax(double price);
}


class VATStrategy implements TaxStrategy {
	private static final double VAT_RATE = 0.10;

	@Override
	public double calculateTax(double price) {
		return price * VAT_RATE;
	}
}


class ConsumptionTaxStrategy implements TaxStrategy {
	private static final double CONSUMPTION_RATE = 0.05;

	@Override
	public double calculateTax(double price) {
		return price * CONSUMPTION_RATE;
	}
}

class LuxuryTaxStrategy implements TaxStrategy {
	private static final double LUXURY_RATE = 0.20;

	@Override
	public double calculateTax(double price) {
		return price * LUXURY_RATE;
	}
}


class Product {
	private String name;
	private double price;
	private TaxStrategy taxStrategy;

	public Product(String name, double price, TaxStrategy taxStrategy) {
		this.name = name;
		this.price = price;
		this.taxStrategy = taxStrategy;
	}

	public double calculateTotalPrice() {
		return price + taxStrategy.calculateTax(price);
	}

	public void setTaxStrategy(TaxStrategy taxStrategy) {
		this.taxStrategy = taxStrategy;
	}
}
