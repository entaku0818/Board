package board.service;

import board.entity.Board;

public class BoardService extends AbstractService<Board> {

    public Board findById() {
        return select().id().getSingleResult();
    }
}