package de.neuefische.mongogeotest;

import org.springframework.data.geo.Circle;
import org.springframework.data.mongodb.core.geo.Sphere;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeoRepo extends MongoRepository<Geo, String> {

    @Query("{\"location\": {$geoWithin: {$center: [[?0, ?1], ?2]}}}")
    List<Geo> findAllInRadius(int x, int y, int radius);


    List<Geo> findAllByLocationIsWithin(Circle circle);


    List<Geo> findAllByLocationWithin(Sphere sphere);
}
