import { legacy_createStore as createStore } from '@reduxjs/toolkit'
import { rootReducer } from './rootReducer'

export const store = createStore(rootReducer)

export type AppState = ReturnType<typeof rootReducer>
export type AppStore = typeof store
