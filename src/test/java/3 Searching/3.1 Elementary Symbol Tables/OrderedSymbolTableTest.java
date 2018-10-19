abstract class OrderedSymbolTableTest extends BasicSymbolTableTest {

    @Override
    OrderedSymbolTable<String, String> getST() {
        return (OrderedSymbolTable<String, String>) super.getST();
    }
}
