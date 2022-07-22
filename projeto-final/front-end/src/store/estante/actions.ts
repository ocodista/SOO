import { createAction } from '@reduxjs/toolkit'
import { ChangeEstanteFailure, ChangeEstanteSuccess, FetchEstanteFailure, FetchEstanteSuccess, SetCurrentEstante } from './types'

export const FETCH_ESTANTE_REQUEST = 'FETCH_ESTANTE_REQUEST'
export const FETCH_ESTANTE_SUCCESS = 'FETCH_ESTANTE_SUCCESS'
export const FETCH_ESTANTE_FAILURE = 'FETCH_ESTANTE_FAILURE'
export const SET_CURRENT_ESTANTE = 'SET_CURRENT_ESTANTE'

export const CHANGE_ESTANTE_REQUEST = 'CHANGE_ESTANTE_REQUEST'
export const CHANGE_ESTANTE_SUCCESS = 'CHANGE_ESTANTE_SUCCESS'
export const CHANGE_ESTANTE_FAILURE = 'CHANGE_ESTANTE_FAILURE'

export const fetchEstanteRequest = createAction(FETCH_ESTANTE_REQUEST)
export const fetchEstanteSuccess = createAction<FetchEstanteSuccess['payload']>(FETCH_ESTANTE_SUCCESS)
export const fetchEstanteFailure = createAction<FetchEstanteFailure['payload']>(FETCH_ESTANTE_FAILURE)

export const setCurrentEstante = createAction<SetCurrentEstante['payload']>(SET_CURRENT_ESTANTE)

export const changeEstanteRequest = createAction(CHANGE_ESTANTE_REQUEST)
export const changeEstanteSuccess = createAction<ChangeEstanteSuccess['payload']>(CHANGE_ESTANTE_SUCCESS)
export const changeEstanteFailure = createAction<ChangeEstanteFailure['payload']>(CHANGE_ESTANTE_FAILURE)
