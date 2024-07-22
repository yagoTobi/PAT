package volta.cars.project.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("HOSTS")
public class HostModel {
    private @Column("USER_ID") Long userId;
    private @Column("HOST_ID") Long hostId;
    private @Column("HOURLY_RATE") float hourlyRate;
    private @Column("RATING") Long rating;
    private @Column("NUMBER_HOSTED") Long numberHosted;
    private @Column("IDENTIFICATION") String identification;

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHostId() {
        return this.hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public float getHourlyRate() {
        return this.hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Long getRating() {
        return this.rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Long getNumberHosted() {
        return this.numberHosted;
    }

    public void setNumberHosted(Long numberHosted) {
        this.numberHosted = numberHosted;
    }

    public String getIdentification() {
        return this.identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
