package org.example.model.entities;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NonNull
@Data
public class CityInCountry {
    @NonNull
    private String title;
    @NonNull
    private int country_id;
}
