
package sorter.array_generators;

public class GeneratorContext {

    private ArrayGenerator _generatorStrategy;

    public GeneratorContext(ArrayGenerator generatorStrategy) throws NullPointerException {
        if (generatorStrategy == null) {
            throw new NullPointerException("Array Generator is null");
        } else {
            _generatorStrategy = generatorStrategy;
        }
    }

    public void setAlgorythm(ArrayGenerator generatorStrategy) throws NullPointerException {
        if (generatorStrategy == null) {
            throw new NullPointerException("Array Generator is null");
        } else {
            _generatorStrategy = generatorStrategy;
        }
    }

    public int[] generate(int length, int maxValue) {
        return _generatorStrategy.generate(length, maxValue);
    }
}
