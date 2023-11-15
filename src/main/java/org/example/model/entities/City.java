package org.example.model.entities;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class City {
    private int id;
    private final String title;
    private Country country;
}
