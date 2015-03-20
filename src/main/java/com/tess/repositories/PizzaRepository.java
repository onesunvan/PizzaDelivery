package com.tess.repositories;

import com.tess.entities.Pizza;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface PizzaRepository {
    List<Pizza> readAll();
}
