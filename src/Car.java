import java.util.ArrayList;
import java.util.List;

class Car {

    private final int id;
    private final String brand;
    private final String model;
    private final int year;
    private final String bodyType;
    private final String color;
    private final double engineVolume;
    private final String gearboxType;
    private final String description;
    private final double price;
    private boolean isSold;
    private final String sellerPhone;

    Car(CarBuilder builder) {
        this.id = builder.id;
        this.brand = builder.brand;
        this.model = builder.model;
        this.year = builder.year;
        this.bodyType = builder.bodyType;
        this.color = builder.color;
        this.engineVolume = builder.engineVolume;
        this.gearboxType = builder.gearboxType;
        this.description = builder.description;
        this.price = builder.price;
        this.isSold = builder.isSold;
        this.sellerPhone = builder.sellerPhone;
    }

    // Геттеры для всех полей
    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getColor() {
        return color;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSold() {
        return isSold;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    // Сеттер для isSold
    public void setSold(boolean sold) {
        isSold = sold;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", bodyType='" + bodyType + '\'' +
                ", color='" + color + '\'' +
                ", engineVolume=" + engineVolume +
                ", gearboxType='" + gearboxType + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isSold=" + isSold +
                ", sellerPhone='" + sellerPhone + '\'' +
                '}';
    }

    public static class CarBuilder {
        private final int id;
        private final String brand;
        private final String model;
        private int year;
        private String bodyType;
        private String color;
        private double engineVolume;
        private String gearboxType;
        private String description;
        private double price;
        private boolean isSold = false; // По умолчанию машина не продана
        private String sellerPhone;

        public CarBuilder(int id, String brand, String model) {
            this.id = id;
            this.brand = brand;
            this.model = model;
        }

        public CarBuilder year(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder bodyType(String bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder engineVolume(double engineVolume) {
            this.engineVolume = engineVolume;
            return this;
        }

        public CarBuilder gearboxType(String gearboxType) {
            this.gearboxType = gearboxType;
            return this;
        }

        public CarBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CarBuilder price(double price) {
            this.price = price;
            return this;
        }

        public CarBuilder sellerPhone(String sellerPhone) {
            this.sellerPhone = sellerPhone;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
