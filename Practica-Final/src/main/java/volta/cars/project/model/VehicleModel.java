package volta.cars.project.model;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("VEHICLES")
public class VehicleModel {
    private @Column("USER_ID") Long userId;
    private @Column("VEHICLE_ID") Long vehicleId;
    private @Column("ELECTRIC") boolean isElectric;
    private @Column("MODEL") String model;
    private @Column("LICENSE_PLATE") String licensePlate;
    private @Column("WATTAGE") float wattage;

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public boolean isIsElectric() {
        return this.isElectric;
    }

    public boolean getIsElectric() {
        return this.isElectric;
    }

    public void setIsElectric(boolean isElectric) {
        this.isElectric = isElectric;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public float getWattage() {
        return this.wattage;
    }

    public void setWattage(float wattage) {
        this.wattage = wattage;
    }

}
