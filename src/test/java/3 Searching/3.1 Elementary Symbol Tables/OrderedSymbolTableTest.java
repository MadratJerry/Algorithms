abstract class OrderedSymbolTableTest extends BasicSymbolTableTest {

    @Override
    OrderedSymbolTable<String, Integer> getST() {
        return (OrderedSymbolTable<String, Integer>) super.getST();
    }
}
