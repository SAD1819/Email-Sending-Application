package io.github.sad1819.portfolio_project.repository;

import io.github.sad1819.portfolio_project.model.PortfolioProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioProjectRepository extends JpaRepository<PortfolioProjectEntity, Long> {

}
