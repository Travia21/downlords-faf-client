package com.faforever.client.tutorial;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface TutorialService {
  CompletableFuture<List<TutorialCategory>> getTutorialCategories();
}
