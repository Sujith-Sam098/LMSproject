package com.project.LMS.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue forumQueue() {
        return new Queue("forumQueue", true);
    }

    @Bean
    public TopicExchange forumExchange() {
        return new TopicExchange("forumExchange");
    }

    @Bean
    public Binding binding(Queue forumQueue, TopicExchange forumExchange) {
        return BindingBuilder.bind(forumQueue).to(forumExchange).with("course.forum.#");
    }
}
