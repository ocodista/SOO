package br.unesp.agrotech;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = SensorMessage.class)
public class SensorMessage {
  // TODO: criar estrutura da mensagem
}