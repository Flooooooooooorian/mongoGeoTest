package de.neuefische.mongogeotest;

import org.springframework.data.mongodb.core.geo.GeoJson;

public record Geo (String id, GeoJson location){
}
