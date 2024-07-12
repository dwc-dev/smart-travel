import request from '@/utils/request'

// 查询景区交通信息，存储景区周边交通列表
export function listTransport(query) {
  return request({
    url: '/system/transport/list',
    method: 'get',
    params: query
  })
}

// 查询景区交通信息，存储景区周边交通详细
export function getTransport(transportId) {
  return request({
    url: '/system/transport/' + transportId,
    method: 'get'
  })
}

// 新增景区交通信息，存储景区周边交通
export function addTransport(data) {
  return request({
    url: '/system/transport',
    method: 'post',
    data: data
  })
}

// 修改景区交通信息，存储景区周边交通
export function updateTransport(data) {
  return request({
    url: '/system/transport',
    method: 'put',
    data: data
  })
}

// 删除景区交通信息，存储景区周边交通
export function delTransport(transportId) {
  return request({
    url: '/system/transport/' + transportId,
    method: 'delete'
  })
}
