import request from '@/utils/request'

// 查询景区交通信息，存储景区周边交通信息列表
export function listTransport(query) {
  return request({
    url: '/system/transport/list',
    method: 'get',
    params: query
  })
}

// 查询景区交通信息，存储景区周边交通信息详细
export function getTransport(transportId) {
  return request({
    url: '/system/transport/' + transportId,
    method: 'get'
  })
}

// 新增景区交通信息，存储景区周边交通信息
export function addTransport(data) {
  return request({
    url: '/system/transport',
    method: 'post',
    data: data
  })
}

// 修改景区交通信息，存储景区周边交通信息
export function updateTransport(data) {
  return request({
    url: '/system/transport',
    method: 'put',
    data: data
  })
}

// 删除景区交通信息，存储景区周边交通信息
export function delTransport(transportId) {
  return request({
    url: '/system/transport/' + transportId,
    method: 'delete'
  })
}
