package controller;

import domain.Table;
import repository.TableRepository;
import service.TableService;
import view.InputView;
import view.OutputView;

public class TableController {

    TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    public Table getTable() {
        OutputView.printTables(TableRepository.tables());
        int tableNumber = InputView.inputTableNumber();
        return tableService.findTableByTableNumber(tableNumber);
    }
}
