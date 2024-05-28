package com.intro.storecoffe.badge;

import com.intro.storecoffe.badge.Badge;
import com.intro.storecoffe.coffee.Coffee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BadgeService {
    @Autowired
    private BadgeRepository repository;

    public List<Badge> getAll(){
        return repository.findAll();
    }

    public Badge getBadgeById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public Badge addBadge(Badge badge) {
        return repository.save(badge);
    }

    public Badge updateBadge(Badge badge,Long id){
        Badge foundBadge = getBadgeById(id);
        foundBadge.setName(badge.getName());
        return repository.save(foundBadge);
    }


    public void deleteBadge( Long id){
        repository.deleteById(id);
    }

    public Badge updateBadge2(Badge badge) {
        return repository.save(badge);
    }
}
