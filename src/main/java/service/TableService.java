package service;

import domain.Table;
import repository.TableRepository;

public class TableService {

    public Table findTableByTableNumber(int tableNumber) {
        return TableRepository.selectTable(tableNumber);
    }

}
