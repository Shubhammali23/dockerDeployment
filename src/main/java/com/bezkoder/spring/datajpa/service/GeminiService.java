package com.bezkoder.spring.datajpa.service;

import com.bezkoder.spring.datajpa.aiConfig.GeminiConfig;
import com.bezkoder.spring.datajpa.repository.TutorialRepository;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {
    private final Client client;
    private final GeminiConfig geminiConfig;
    private final TutorialRepository tutorialRepository;

    public GeminiService(GeminiConfig geminiConfig,
                         TutorialRepository tutorialRepository, Client client) {
        this.geminiConfig = geminiConfig;
        this.tutorialRepository = tutorialRepository;
        this.client = client;
    }

    public String askGemini(String prompt) {

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        prompt,
                        null);

        return response.text();
    }
}
