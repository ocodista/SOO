import { EstanteType } from '../../services/types'
import { CHANGE_ESTANTE_FAILURE, CHANGE_ESTANTE_REQUEST, CHANGE_ESTANTE_SUCCESS, FETCH_ESTANTE_FAILURE, FETCH_ESTANTE_REQUEST, FETCH_ESTANTE_SUCCESS, SET_CURRENT_ESTANTE } from './actions'

export type EstanteState = {
  loading: boolean;
  estantes: EstanteType[];
  current: EstanteType | null;
  error: string | null;
}

export type FetchEstanteRequest = {
  type: typeof FETCH_ESTANTE_REQUEST;
}

export type FetchEstanteSuccess = {
  type: typeof FETCH_ESTANTE_SUCCESS;
  payload: { estantes: EstanteState['estantes'] }
}

export type FetchEstanteFailure = {
  type: typeof FETCH_ESTANTE_FAILURE;
  payload: { error: EstanteState['error'] }
}

export type ChangeEstanteRequest = {
  type: typeof CHANGE_ESTANTE_REQUEST;
}

export type ChangeEstanteSuccess = {
  type: typeof CHANGE_ESTANTE_SUCCESS;
  payload: { estantes: EstanteState['estantes'] }
}

export type ChangeEstanteFailure = {
  type: typeof CHANGE_ESTANTE_FAILURE;
  payload: { error: EstanteState['error'] }
}

export type SetCurrentEstante = {
  type: typeof SET_CURRENT_ESTANTE;
  payload: { estante: EstanteState['current'] }
}

export type EstanteActions = FetchEstanteRequest
  | FetchEstanteSuccess
  | FetchEstanteFailure
  | ChangeEstanteRequest
  | ChangeEstanteSuccess
  | ChangeEstanteFailure
  | SetCurrentEstante
