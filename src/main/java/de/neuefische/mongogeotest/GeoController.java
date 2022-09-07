package de.neuefische.mongogeotest;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.geojson.Position;
import org.bson.Document;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.Sphere;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/geo")
public class GeoController {

    private final GeoRepo geoRepo;

    public GeoController(GeoRepo geoRepo) {
        this.geoRepo = geoRepo;
    }

    @GetMapping
    List<Geo> findAll() {
        return geoRepo.findAll();
    }

    @PostMapping
    Geo addGeo(@RequestBody Geo geo) {
        return geoRepo.save(geo);
    }

    @GetMapping("{radius}")
    List<Geo> findInCircle(@PathVariable int radius) {
        //return geoRepo.findAllInRadius(0, 0, radius);
        //return geoRepo.findAllByLocationIsWithin(new Circle(0, 0, radius));
        return geoRepo.findAllByLocationWithin(new Sphere(new Point(0,0), radius));
    }
}
