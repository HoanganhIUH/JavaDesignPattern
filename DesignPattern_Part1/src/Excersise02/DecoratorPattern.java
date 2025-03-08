package Excersise02;

//Interface cơ bản cho sản phẩm
interface ProductComponent {
	double getPrice();
	String getDescription();
}

//Sản phẩm cơ bản
class BasicProduct implements ProductComponent {
	private String name;
	private double price;

	public BasicProduct(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getDescription() {
		return name;
	}
}

//Decorator trừu tượng
abstract class TaxDecorator implements ProductComponent {
	protected ProductComponent decoratedProduct;

	public TaxDecorator(ProductComponent decoratedProduct) {
		this.decoratedProduct = decoratedProduct;
	}

	@Override
	public double getPrice() {
		return decoratedProduct.getPrice();
	}

	@Override
	public String getDescription() {
		return decoratedProduct.getDescription();
	}
}

//Decorator cho thuế VAT
class VATDecorator extends TaxDecorator {
	private static final double VAT_RATE = 0.10;

	public VATDecorator(ProductComponent decoratedProduct) {
		super(decoratedProduct);
	}

	@Override
	public double getPrice() {
		return super.getPrice() + (super.getPrice() * VAT_RATE);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + " + VAT";
	}
}

//Decorator cho thuế xa xỉ
class LuxuryTaxDecorator extends TaxDecorator {
	private static final double LUXURY_RATE = 0.20;

	public LuxuryTaxDecorator(ProductComponent decoratedProduct) {
		super(decoratedProduct);
	}

	@Override
	public double getPrice() {
		return super.getPrice() + (super.getPrice() * LUXURY_RATE);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + " + Luxury Tax";
	}
}