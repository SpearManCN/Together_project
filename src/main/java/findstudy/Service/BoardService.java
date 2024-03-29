package findstudy.Service;

import findstudy.Domain.MainBoard;
import findstudy.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
@Transactional
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public MainBoard saveBoard(MainBoard mainBoard){
        return boardRepository.save(mainBoard);
    }

    public List<MainBoard> selectAll(Integer sort){
        return boardRepository.findBySortOrderByNoDesc(sort);
    }

    public MainBoard findByNo(Integer no){return boardRepository.findByNo(no);}

    public List<MainBoard> selectAllSearch(Integer sort, String search){
        return boardRepository.findSearchedBoards(sort, search);
    }

    public void updateView(int no){
        boardRepository.updateView(no);
    }
}
