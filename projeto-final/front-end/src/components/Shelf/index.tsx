import { GridItem, Text } from '@chakra-ui/react'
import { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { EstanteType } from '../../services/types'
import { AppState } from '../../store'
import { fetchEstanteFailure, fetchEstanteRequest, fetchEstanteSuccess, setCurrentEstante } from '../../store/estante/actions'

interface IEstanteContainer {
  estantes: EstanteType[]
}

export function Shelf ({ estantes }: IEstanteContainer) {
  const dispatch = useDispatch()
  const { estantes: estantesState, loading, current } = useSelector(({ estante }: AppState) => estante)

  useEffect(() => {
    dispatch(fetchEstanteRequest())
    if (estantes) {
      dispatch(fetchEstanteSuccess({ estantes }))
      dispatch(setCurrentEstante({ estante: estantes[0] }))
    } else {
      dispatch(fetchEstanteFailure({ error: 'Erro ao fazer fetch de estante' }))
    }
  }, [])

  function handleCurrentEstante (estante: EstanteType) {
    dispatch(setCurrentEstante({ estante }))
  }

  return (
    <GridItem
      area="nav1"
      display="flex"
      flexDirection="column"
      paddingY="1rem"
      borderRadius="0.5rem"
      border="2px solid"
      borderColor="gray.400"
    >
      { loading
        ? (
            <Text>...Carregando</Text>
          )
        : (
            estantesState.map((estante) => (
              <Text
                key={estante.id}
                cursor="pointer"
                _hover={{
                  backgroundColor: 'gray.400',
                  color: 'white'
                }}
                paddingX="1rem"
                onClick={() => handleCurrentEstante(estante)}
                fontWeight={current?.id === estante.id ? 'bold' : 'normal'}
              >
                {`Estante ${estante.id}`}
              </Text>
            ))
          )}
    </GridItem>
  )
}
