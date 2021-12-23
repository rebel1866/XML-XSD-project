package by.epamtc.stanislavmelnikov.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Flower implements Serializable {
    private String id;
    private String name;
    private String soil;
    private String origin;
    private String stemColor;
    private String leavesColor;
    private int avgFlowerSize;
    private int temperature;
    private boolean isLightening;
    private int watering;
    private String multiplying;
    private LocalDateTime recDateTime;

    public Flower() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }


    public String getStemColor() {
        return stemColor;
    }

    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public String getLeavesColor() {
        return leavesColor;
    }

    public void setLeavesColor(String leavesColor) {
        this.leavesColor = leavesColor;
    }

    public int getAvgFlowerSize() {
        return avgFlowerSize;
    }

    public void setAvgFlowerSize(int avgFlowerSize) {
        this.avgFlowerSize = avgFlowerSize;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isLightening() {
        return isLightening;
    }

    public void setLightening(boolean lightening) {
        isLightening = lightening;
    }

    public int getWatering() {
        return watering;
    }

    public void setWatering(int watering) {
        this.watering = watering;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    public LocalDateTime getRecDateTime() {
        return recDateTime;
    }

    public void setRecDateTime(LocalDateTime recDateTime) {
        this.recDateTime = recDateTime;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", soil='" + soil + '\'' +
                ", origin='" + origin + '\'' +
                ", stemColor='" + stemColor + '\'' +
                ", leavesColor='" + leavesColor + '\'' +
                ", avgFlowerSize=" + avgFlowerSize +
                ", temperature=" + temperature +
                ", isLightening=" + isLightening +
                ", watering=" + watering +
                ", multiplying='" + multiplying + '\'' +
                ", recDateTime=" + recDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        if (null == id) {
            return id == flower.id;
        } else {
            if (!id.equals(flower.id)) {
                return false;
            }
        }
        if (null == name) {
            return name == flower.name;
        } else {
            if (!name.equals(flower.name)) {
                return false;
            }
        }
        if (null == soil) {
            return soil == flower.soil;
        } else {
            if (!soil.equals(flower.soil)) {
                return false;
            }
        }
        if (null == origin) {
            return origin == flower.origin;
        } else {
            if (!origin.equals(flower.origin)) {
                return false;
            }
        }
        if (null == stemColor) {
            return stemColor == flower.stemColor;
        } else {
            if (!stemColor.equals(flower.stemColor)) {
                return false;
            }
        }
        if (null == multiplying) {
            return multiplying == flower.multiplying;
        } else {
            if (!multiplying.equals(flower.multiplying)) {
                return false;
            }
        }
        if (null == recDateTime) {
            return recDateTime == flower.recDateTime;
        } else {
            if (!recDateTime.equals(flower.recDateTime)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return ((null == id) ? 0 : id.hashCode()) +
                ((null == name) ? 0 : name.hashCode()) + 31 * avgFlowerSize + ((null == soil) ? 0 : soil.hashCode()) +
                ((null == origin) ? 0 : origin.hashCode()) + ((null == stemColor) ? 0 : stemColor.hashCode()) +
                ((null == multiplying) ? 0 : multiplying.hashCode()) + ((null == recDateTime) ? 0 : recDateTime.hashCode());
    }
}
