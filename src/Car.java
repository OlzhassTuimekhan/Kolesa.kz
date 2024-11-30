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
    private final String vinCode;
    private String licensePlate;


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
        this.licensePlate = licensePlate;
        this.vinCode = builder.vinCode;
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
    public String getVinCode() {
        return vinCode;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    // Сеттер для isSold
    public void setSold(boolean sold) {
        isSold = sold;
    }


    @Override
    public String toString() {
        int width = 60; // Общая ширина рамки (включая границы)
        String border = "━".repeat(width);

        return border + "\n" +
                formatRow("Car ID", id, width) +
                formatRow("Brand", brand, width) +
                formatRow("Model", model, width) +
                formatRow("Year", year, width) +
                formatRow("Body Type", bodyType, width) +
                formatRow("Color", color, width) +
                formatRow("Engine Volume", engineVolume + "L", width) +
                formatRow("Gearbox Type", gearboxType, width) +
                formatRow("Description", description, width) +
                formatRow("Price", String.format("%,.0f KZT", price), width) +
                formatRow("Seller Phone", sellerPhone, width) +
                formatRow("Status", isSold ? "SOLD" : "AVAILABLE", width) +
                formatRow("License Plate", licensePlate != null ? licensePlate : "Not assigned", width) +
                formatRow("VIN Code", vinCode, width) +
                border;
    }

    // Вспомогательный метод для форматирования строки
    private String formatRow(String key, Object value, int width) {
        String content = String.format("▐ %-15s : %-"+(width - 20)+"s▐", key, value);
        return content + "\n";
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
        private String vinCode;
        private String licensePlate;

        public CarBuilder(int id, String brand, String model) {
            this.id = id;
            this.brand = brand;
            this.model = model;
        }

        public CarBuilder year(int year) {
            this.year = year > 0 ? year : 2000; // Значение по умолчанию
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
            if (price <= 0) {
                throw new IllegalArgumentException("Price must be greater than 0.");
            }
            this.price = price;
            return this;
        }

        public CarBuilder licensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }


        public CarBuilder sellerPhone(String sellerPhone) {
            this.sellerPhone = sellerPhone;
            return this;
        }
        public CarBuilder vinCode(String vinCode) {
            this.vinCode = vinCode;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
