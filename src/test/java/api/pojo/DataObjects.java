package api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataObjects {
    private String id;
    private String name;

    @JsonProperty("data")
    private Object data;

    // Default Constructor
    public DataObjects() {}

    // Parameterized Constructor
    public DataObjects(String id, String name, Object data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Object getData() { return data; }
    public void setData(Data data) { this.data = data; }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", data=" + data +
                '}';
    }

    // Nested class for 'data' field
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Data {
        private String color;
        private String capacity;
        private String generation;
        private String price;
        private Integer year;
        @JsonProperty("CPU model")
        private String cpuModel;
        @JsonProperty("Hard disk size")
        private String hardDiskSize;
        @JsonProperty("Strap Colour")
        private String strapColour;
        @JsonProperty("Case Size")
        private String caseSize;
        @JsonProperty("Capacity")
        private String capacityAlt; // Alternate mapping for 'Capacity'
        @JsonProperty("Screen size")
        private Double screenSize;
        @JsonProperty("Description")
        private String description;

        // Default Constructor
        public Data() {}

        // Getters and Setters
        public String getColor() { return color; }
        public void setColor(String color) { this.color = color; }

        public String getCapacity() { return capacity; }
        public void setCapacity(String capacity) { this.capacity = capacity; }

        public String getGeneration() { return generation; }
        public void setGeneration(String generation) { this.generation = generation; }

        public String getPrice() { return price; }
        public void setPrice(String price) { this.price = price; }

        public Integer getYear() { return year; }
        public void setYear(Integer year) { this.year = year; }

        public String getCpuModel() { return cpuModel; }
        public void setCpuModel(String cpuModel) { this.cpuModel = cpuModel; }

        public String getHardDiskSize() { return hardDiskSize; }
        public void setHardDiskSize(String hardDiskSize) { this.hardDiskSize = hardDiskSize; }

        public String getStrapColour() { return strapColour; }
        public void setStrapColour(String strapColour) { this.strapColour = strapColour; }

        public String getCaseSize() { return caseSize; }
        public void setCaseSize(String caseSize) { this.caseSize = caseSize; }

        public String getCapacityAlt() { return capacityAlt; }
        public void setCapacityAlt(String capacityAlt) { this.capacityAlt = capacityAlt; }

        public Double getScreenSize() { return screenSize; }
        public void setScreenSize(Double screenSize) { this.screenSize = screenSize; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        @Override
        public String toString() {
            return "Data{" +
                    "color='" + color + '\'' +
                    ", capacity='" + capacity + '\'' +
                    ", generation='" + generation + '\'' +
                    ", price='" + price + '\'' +
                    ", year=" + year +
                    ", cpuModel='" + cpuModel + '\'' +
                    ", hardDiskSize='" + hardDiskSize + '\'' +
                    ", strapColour='" + strapColour + '\'' +
                    ", caseSize='" + caseSize + '\'' +
                    ", capacityAlt='" + capacityAlt + '\'' +
                    ", screenSize=" + screenSize +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
