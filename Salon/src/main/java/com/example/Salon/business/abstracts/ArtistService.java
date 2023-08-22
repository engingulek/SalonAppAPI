package com.example.Salon.business.abstracts;

import com.example.Salon.core.utilities.results.DataResult;
import com.example.Salon.entities.concretes.Artist;


import java.util.List;

public interface ArtistService {
    DataResult<List<Artist>> getAll();
}
