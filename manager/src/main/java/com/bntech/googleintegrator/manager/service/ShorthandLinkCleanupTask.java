package com.bntech.googleintegrator.manager.service;

import com.bntech.googleintegrator.manager.data.repository.ShorthandLinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
@RequiredArgsConstructor
public class ShorthandLinkCleanupTask {

    private final ShorthandLinkRepository shorthandLinkRepository;

    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteOldShorthandLinks() {
        Instant expiryDate = Instant.now().minus(30, ChronoUnit.DAYS);
        shorthandLinkRepository.deleteAllCreatedBefore(expiryDate);
    }
}
