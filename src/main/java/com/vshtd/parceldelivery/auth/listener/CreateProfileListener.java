package com.vshtd.parceldelivery.auth.listener;

import com.vshtd.parceldelivery.auth.model.mqo.CreateProfileMQO;
import com.vshtd.parceldelivery.auth.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CreateProfileListener {

    @Autowired
    private ProfileService profileService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${rabbitmq.create-profile.queue}", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "${rabbitmq.create-profile.exchange}"),
            key = "${rabbitmq.create-profile.rk}")
    )
    public void receive(CreateProfileMQO profile) {
        log.info("RMQ | create profile received, username: " + profile.getUsername());
        profileService.createProfile(profile);
    }
}
