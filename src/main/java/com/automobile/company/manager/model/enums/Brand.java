package com.automobile.company.manager.model.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum Brand {
    NEXA,
    KIA,
    BMW,
    AUDI,
    MARUTHI,
    THAR,
    FORD,
    TATA;

    public static final Map<Brand, Set<Model>> brandModelMap = new HashMap<>();

    static {
        brandModelMap.put(Brand.MARUTHI, Set.of(Model.LXI, Model.VXI, Model.ZXI));
        brandModelMap.put(Brand.THAR, Set.of(Model.FRONT_BASED, Model.BACK_BASED));
        brandModelMap.put(Brand.KIA, Set.of(Model.LXI, Model.VXI));
        brandModelMap.put(Brand.BMW, Set.of(Model.LXI, Model.VXI));
        brandModelMap.put(Brand.AUDI, Set.of(Model.A4, Model.A5));
        brandModelMap.put(Brand.NEXA, Set.of(Model.SPORTS));
    }
}
