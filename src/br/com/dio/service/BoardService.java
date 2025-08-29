package br.com.dio.service;

import br.com.dio.model.Board;
import br.com.dio.model.GameStatusEnum;
import br.com.dio.model.Space;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardService {

    private final static int BOARD_LIMIT = 9;

    private final Board board;

    public BoardService(final Map<String, Space> gameConfig) {
        this.board = new Board(initBoard(gameConfig));
    }

    public List<List<Space>> getSpaces() {
        return board.getSpaces();
    }

    public void reset() {
        board.reset();
    }

    public boolean hasErrors() {
        return board.hasErrors();
    }

    public GameStatusEnum getStatus() {
        return board.getStatus();
    }

    public boolean gameIsFinished() {
        return board.gameIsFinished();
    }


    private List<List<Space>> initBoard(final Map<String, Space> gameConfig) {
        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                // Pega o Space já criado no GameRepository
                var currentSpace = gameConfig.get("%s,%s".formatted(i, j));
                spaces.get(i).add(new Space(currentSpace.getExpected(), currentSpace.isFixed()));
            }
        }
        return spaces;
    }
}
