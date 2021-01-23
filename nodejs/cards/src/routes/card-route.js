const api = require("../controllers/card-controller");

module.exports = (app) => {
  app.get("/cards", api.findAll);
  app.get("/cards/:id", api.find);
  app.post("/cards", api.save);
  app.delete("/cards/:id", api.remove);
  app.put("/cards/:id", api.update)
};
