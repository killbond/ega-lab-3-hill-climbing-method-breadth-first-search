public class Main {

    public static void main(String[] args) {
        int L = 5,
            N = 20;

        EncodingCollection collection = new EncodingCollection(L);

        Encoding maxS = collection.getRandom();
        int max = maxS.getAdaptability().square(L);

        for (int i = 0; i < N; i++) {

            System.out.println("\nШаг: " + i);
            System.out.println("Текущий max: " + max + ", текущий maxS: (" + maxS.getValue() + ") " + maxS.toString(L));

            EncodingCollection surroundings = collection.getSurroundings(maxS);

            System.out.println("Окрестность для текущего шага: " + surroundings.toString());
            Encoding maxO = surroundings.getMax();

            System.out.println("Выбран maxO: " + maxO.toString(L) + " (" + maxO.getValue() + "), ее приспособленность: " + maxO.getAdaptability().square(L));
            if (maxO.getAdaptability().square(L) > max) {
                maxS = maxO;
                max = maxO.getAdaptability().square(L);
                System.out.println("Установлено новое значение maxS: " + maxS.toString(L) + " (" + maxS.getValue() + "), и max: " + max);
            } else {
                System.out.println("Среди окрестности текущей более лучшей кодировки не найдено, останов алгоритма");
                break;
            }
        }

        System.out.println("\nКонечная max: " + max + ", конечная maxS: (" + maxS.getValue() + ") " + maxS.toString(L));
    }
}
