package com.learner.configuration;

import org.apache.kafka.streams.kstream.KStream;

public interface StreamBindings {
KStream<String, Object> inputStream();
KStream<String, Object> smsStream();
KStream<String, Object> emailStream();
}
