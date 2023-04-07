package org.koreait.repositories;

import org.koreait.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board , String> {
}
