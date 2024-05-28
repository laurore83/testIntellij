package com.intro.storecoffe.badge;

import com.intro.storecoffe.coffee.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BadgeRepository extends JpaRepository<Badge, Long> {
}
