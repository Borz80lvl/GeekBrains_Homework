import java.util.TreeMap;

class Laptops {

    private Integer RAM;
    private Integer Storage;
    private String GPU;
    private String Display;
    private Integer Battery;
    private String[] Ports;
    private String OperationSystem;
    private Integer Size;
    private Integer Weight;
    TreeMap<String, TreeMap<String, Object>> Laptops = new TreeMap<>();

    public Laptops(String name, Integer RAM, Integer Storage, String GPU, String Display, Integer Battery, String[] Ports, String OS, Integer size, Integer weight) {
        TreeMap<String, Object> tempLaptop = new TreeMap<>();
        tempLaptop.put("RAM", RAM);
        tempLaptop.put("Storage", Storage);
        tempLaptop.put("GPU", GPU);
        tempLaptop.put("Display", Display);
        tempLaptop.put("Battery", Battery);
        tempLaptop.put("Ports", Ports);
        tempLaptop.put("OS", OS);
        tempLaptop.put("Size", size);
        tempLaptop.put("Weight", weight);



    }

}