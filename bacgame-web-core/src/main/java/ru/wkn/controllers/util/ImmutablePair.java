package ru.wkn.controllers.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ImmutablePair<F, S> {

    private F fField;
    private S sField;
}
