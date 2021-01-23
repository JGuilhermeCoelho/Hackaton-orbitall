const { request, response } = require("express");
const neDB = require("../configurations/database");
const api = {};

api.findAll = (request, response) => {
  neDB.find({}).exec((exception, cards) => {
    if (exception) {
      const setence = "It was not possible to list the cards!";
      console.log(setence, exception);
      response.status(exception.status | 400);
      response.json({ mensagem: setence });
    }
    response.status(201);
    response.json(cards);
  });
};

api.save = (request, response) => {
  const canonical = request.body;
  neDB.insert(canonical, (exception, card) => {
    if (exception) {
      const setence = "The card could not be saved!";
      console.log(setence, exception);
      response.status(exception.status | 400);
      response.json({ mensagem: setence });
    }
    response.status(201);
    response.json(card);
  });
};

api.find = (request, response) => {
  neDB
    .findOne({
      _id: parseInt(request.params.id),
    })
    .exec((exception, card) => {
      if (exception) {
        const setence = "It was not possible to list the card!";
        console.log(setence, exception);
        response.status(exception.status | 400);
        response.json({ mensagem: setence });
      }
      response.status(201);
      response.json(card);
    });
};

api.remove = (request, response) => {
  neDB.remove(
    { _id: parseInt(request.params.id) },
    {},
    (exception, cardRemoved) => {
      if (exception) {
        const setence = "It was not possible to remove the card!";
        console.log(setence, exception);
        response.status(exception.status | 400);
        response.json({ mensagem: setence });
      }
      response.status(201);
      response.json(cardRemoved);
    }
  );
};

api.update = (request, response) => {
  const canonical = request.body;

  neDB.update(
    { _id: parseInt(request.params.id) },
    canonical,
    {},
    (exception, cardUpdated) => {
      if (exception) {
        const sentence = "It was not possible to update the card!";
        console.log(sentence, exception);

        response.status(exception.status | 400);
        response.json({ message: sentence });
      }
      response.status(201);
      response.json(cardUpdated);
    }
  );
};

module.exports = api;
