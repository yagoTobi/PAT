package volta.cars.project.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import volta.cars.project.model.HostModel;

public interface HostRepository extends CrudRepository<HostModel, String> {

    //Como hacer un Post 
    @Modifying
    @Query("INSERT INTO HOSTS (USER_ID, HOURLY_RATE, NUMBER_HOSTED, IDENTIFICATION) VALUES (:userId, :hourlyRate, :numberHosted, :identification)")
    public void addHost(Long userId, float hourlyRate, Long numberHosted, String identification);

    @Query("SELECT * FROM HOSTS WHERE HOSTS.USER_ID = :userId ")
    public Iterable<HostModel> getHostById(Long userId);

}
