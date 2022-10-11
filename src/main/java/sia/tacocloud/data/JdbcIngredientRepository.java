package sia.tacocloud.data;

import sia.tacocloud.model.Ingredient;

import java.util.Optional;

public class JdbcIngredientRepository implements IngredientRepository {
    @Override
    public Iterable<Ingredient> findAll() {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }
}
