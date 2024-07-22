package volta.cars.project.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("CHARGERS")
public class ChargerModel {
    private @Column("USER_ID") Long userId;
    private @Column("CHARGER_ID") Long chargerId;
    private @Column("LATITUDE") float latitude;
    private @Column("LONGITUDE") float longitude;
    private @Column("CHARGER_TYPE") String chargerType;
    
    public Long getUserId() {
        return userId;
    }
    public String getChargerType() {
        return chargerType;
    }
    
    public float getLatitude() {
        return latitude;
    }
    public float getLongitude() {
        return longitude;
    }
<<<<<<< HEAD
=======
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chargerId == null) ? 0 : chargerId.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChargerModel other = (ChargerModel) obj;
        if (chargerId == null) {
            if (other.chargerId != null)
                return false;
        } else if (!chargerId.equals(other.chargerId))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

   
>>>>>>> b9dbd639319a1783d2a190bd83f3da738ac3d7b3
}
