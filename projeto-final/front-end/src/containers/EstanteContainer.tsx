import { GridItem, Text } from '@chakra-ui/react'
import { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { EstanteType } from '../services/types'
import { AppState } from '../store'
import { fetchEstanteFailure, fetchEstanteRequest, fetchEstanteSuccess } from '../store/estante/actions'

interface IEstanteContainer {
  estantes: EstanteType[]
}

export function EstanteContainer ({ estantes }: IEstanteContainer) {
  const dispatch = useDispatch()
  const { estantes: estantesState, loading } = useSelector(({ estante }: AppState) => estante)

  useEffect(() => {
    dispatch(fetchEstanteRequest())
    if (estantes) {
      dispatch(fetchEstanteSuccess({ estantes }))
    } else {
      dispatch(fetchEstanteFailure({ error: 'Erro ao fazer fetch de estante' }))
    }
  }, [dispatch, estantes])

  return (
    <GridItem
      area="nav1"
      display="flex"
      flexDirection="column"
      padding="1rem"
      borderRadius="0.5rem"
      border="2px solid"
      borderColor="gray.400"
    >
      { loading ? <Text>...Carregando</Text> : estantesState.map(estante => <Text key={estante.id}>{`Estante ${estante.id}`}</Text>)}
    </GridItem>
  )
}
