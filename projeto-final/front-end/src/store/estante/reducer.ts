import { FETCH_ESTANTE_FAILURE, FETCH_ESTANTE_REQUEST, FETCH_ESTANTE_SUCCESS, SET_CURRENT_ESTANTE } from './actions'
import { EstanteActions, EstanteState } from './types'

const estanteInitialState: EstanteState = {
  error: null,
  loading: false,
  current: null,
  estantes: []
}

export const estanteReducer = (state: EstanteState = estanteInitialState, action: EstanteActions): EstanteState => {
  switch (action.type) {
    case FETCH_ESTANTE_REQUEST:
      return {
        ...state,
        loading: true
      }
    case FETCH_ESTANTE_SUCCESS:
      return {
        ...state,
        loading: false,
        error: null,
        estantes: action.payload.estantes
      }
    case FETCH_ESTANTE_FAILURE:
      return {
        ...state,
        loading: false,
        error: action.payload.error
      }
    case SET_CURRENT_ESTANTE:
      return {
        ...state,
        loading: false,
        error: null,
        current: action.payload.estante
      }
    default:
      return {
        ...state
      }
  }
}
