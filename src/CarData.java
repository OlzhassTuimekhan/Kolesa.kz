import java.util.ArrayList;
import java.util.List;

public class CarData {
    public static List<Car> getPredefinedCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car.CarBuilder(1, "Toyota", "Corolla")
                .year(2011)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(10500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(2, "Toyota", "Camry")
                .year(2012)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(11000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(3, "Toyota", "Hilux")
                .year(2013)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(11500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(4, "Toyota", "Land Cruiser")
                .year(2014)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(12000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(5, "Toyota", "Prado")
                .year(2015)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(12500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(6, "Toyota", "Yaris")
                .year(2016)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(13000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(7, "Toyota", "RAV4")
                .year(2017)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(13500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(8, "Toyota", "Highlander")
                .year(2018)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(14000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(9, "Toyota", "4Runner")
                .year(2019)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(14500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(10, "Toyota", "Avalon")
                .year(2020)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(15000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(11, "Honda", "Civic")
                .year(2021)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(15500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(12, "Honda", "Accord")
                .year(2022)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(16000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(13, "Honda", "CR-V")
                .year(2010)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(16500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(14, "Honda", "Pilot")
                .year(2011)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(17000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(15, "Honda", "Fit")
                .year(2012)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(17500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(16, "Honda", "HR-V")
                .year(2013)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(18000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(17, "Honda", "Odyssey")
                .year(2014)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(18500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(18, "Honda", "Ridgeline")
                .year(2015)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(19000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(19, "Honda", "Insight")
                .year(2016)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(19500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(20, "Honda", "Passport")
                .year(2017)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(20000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(21, "Ford", "Focus")
                .year(2018)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(20500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(22, "Ford", "Fusion")
                .year(2019)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(21000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(23, "Ford", "Escape")
                .year(2020)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(21500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(24, "Ford", "Explorer")
                .year(2021)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(22000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(25, "Ford", "Edge")
                .year(2022)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(22500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(26, "Ford", "Mustang")
                .year(2010)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(23000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(27, "Ford", "Expedition")
                .year(2011)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(23500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(28, "Ford", "Ranger")
                .year(2012)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(24000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(29, "Ford", "F-150")
                .year(2013)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(24500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(30, "Ford", "Bronco")
                .year(2014)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(25000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(31, "Chevrolet", "Malibu")
                .year(2015)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(25500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(32, "Chevrolet", "Impala")
                .year(2016)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(26000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(33, "Chevrolet", "Equinox")
                .year(2017)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(26500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(34, "Chevrolet", "Traverse")
                .year(2018)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(27000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(35, "Chevrolet", "Tahoe")
                .year(2019)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(27500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(36, "Chevrolet", "Suburban")
                .year(2020)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(28000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(37, "Chevrolet", "Colorado")
                .year(2021)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(28500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(38, "Chevrolet", "Silverado")
                .year(2022)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(29000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(39, "Chevrolet", "Blazer")
                .year(2010)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(29500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(40, "Chevrolet", "Camaro")
                .year(2011)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(30000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(41, "Nissan", "Altima")
                .year(2012)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(30500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(42, "Nissan", "Maxima")
                .year(2013)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(31000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(43, "Nissan", "Rogue")
                .year(2014)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(31500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(44, "Nissan", "Murano")
                .year(2015)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(32000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(45, "Nissan", "Pathfinder")
                .year(2016)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(32500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(46, "Nissan", "Frontier")
                .year(2017)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(33000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(47, "Nissan", "Titan")
                .year(2018)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(33500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(48, "Nissan", "Sentra")
                .year(2019)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(34000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(49, "Nissan", "Versa")
                .year(2020)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(34500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(50, "Nissan", "Armada")
                .year(2021)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(35000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(51, "Hyundai", "Elantra")
                .year(2022)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(35500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(52, "Hyundai", "Sonata")
                .year(2010)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(36000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(53, "Hyundai", "Tucson")
                .year(2011)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(36500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(54, "Hyundai", "Santa Fe")
                .year(2012)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(37000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(55, "Hyundai", "Kona")
                .year(2013)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(37500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(56, "Hyundai", "Palisade")
                .year(2014)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(38000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(57, "Hyundai", "Accent")
                .year(2015)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("White")
                .engineVolume(2.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(38500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(58, "Hyundai", "Veloster")
                .year(2016)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("Black")
                .engineVolume(2.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(39000)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(59, "Hyundai", "Ioniq")
                .year(2017)  // Random year between 2010-2022
                .bodyType("SUV")
                .color("White")
                .engineVolume(3.0)  // Random engine volume
                .gearboxType("Manual")
                .description("Powerful and spacious vehicle.")
                .price(39500)  // Random price increment
                .sellerPhone("+123456789")
                .build());

        cars.add(new Car.CarBuilder(60, "Hyundai", "Genesis")
                .year(2018)  // Random year between 2010-2022
                .bodyType("Sedan")
                .color("Black")
                .engineVolume(1.5)  // Random engine volume
                .gearboxType("Automatic")
                .description("Reliable and fuel-efficient car.")
                .price(40000)  // Random price increment
                .sellerPhone("+123456789")
                .build());
        return cars;
    }
}
