import { combineReducers } from 'redux'
import { estanteReducer } from './estante/reducer'

export const rootReducer = combineReducers({
  estante: estanteReducer
})
