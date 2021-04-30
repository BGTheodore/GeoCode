import { combineReducers } from "redux";
import changeState  from "./changeState";
// import books from "./books";

export default combineReducers({
  changeState: changeState,
  // books,
});
